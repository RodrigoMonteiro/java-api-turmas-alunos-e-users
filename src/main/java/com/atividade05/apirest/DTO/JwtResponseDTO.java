package com.atividade05.apirest.DTO;

import java.io.Serializable;

public class JwtResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String token;

	public JwtResponseDTO() {

	}

	public JwtResponseDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	
}
