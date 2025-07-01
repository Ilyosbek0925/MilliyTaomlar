package org.spring.milliytaomlar.service;

import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.LoginRequest;
import org.spring.milliytaomlar.DTO.request.RegisterRequest;
import org.spring.milliytaomlar.DTO.response.UserResponse;
import org.spring.milliytaomlar.config.JwtService;
import org.spring.milliytaomlar.entity.User;
import org.spring.milliytaomlar.mapper.RegisterMapper;
import org.spring.milliytaomlar.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserRepository repository;
    private final RegisterMapper mapper;
    private final JwtService jwtService;

    public UserResponse register(RegisterRequest request) {
        User user = mapper.toUser(request);

        User save = repository.save(user);

        return mapper.toRegisterResponse(save);
    }

    public String login(LoginRequest request, AuthenticationManager authenticationManager) {
        System.out.println("login1 log");
        System.out.println(request.getEmail());
        System.out.println(request.getPassword());
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        System.out.println("login2 log");
        User principal = (User) authenticate.getPrincipal();
        return jwtService.generateToken(principal.getUsername());


    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
