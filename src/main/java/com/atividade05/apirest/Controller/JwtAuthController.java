package com.atividade05.apirest.Controller;

import com.atividade05.apirest.DTO.JwtResponseDTO;
import com.atividade05.apirest.DTO.UserDTO;
import com.atividade05.apirest.Security.JwtTokenUtil;
import com.atividade05.apirest.Service.JwtUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthController {

    @Autowired
    private com.atividade05.apirest.Security.JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtService;

    @PostMapping("/authenticate")
    @ResponseBody
    public ResponseEntity<com.atividade05.apirest.DTO.JwtResponseDTO> createAuthenticationToken(@RequestBody UserDTO authenticationRequest) throws Exception {        
        final UserDetails userDetails = jwtService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        
        return ResponseEntity.ok(new JwtResponseDTO(token));
    }
}
