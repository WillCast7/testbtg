package com.btgpactual.ssf.dto;

import lombok.Data;

import org.springframework.data.domain.Pageable;
import java.io.Serializable;

@Data
public class APIResponseDTO<T> implements Serializable {

	private boolean state = false;
	private String message = null;
	private String error = null;
	private String code = null;
	private T data = null;
	private Pageable pageable = null;

	//Respuesta con data
	public void setResponse(T data, String message, String code) {
		this.setMessage(message);
		this.setCode(code);
		this.setState(Boolean.TRUE);
		this.setData(data);
	}

	//Respuesta con data para listar
	public void setPageable(T data, String message, String code, Pageable pageable) {
		this.setMessage(message);
		this.setCode(code);
		this.setState(Boolean.TRUE);
		this.setData(data);
		this.setPageable(pageable);
	}

	//Respuesta positiva sin data
	public void setSuccess(String message, String code) {
		this.setMessage(message);
		this.setCode(code);
		this.setState(Boolean.TRUE);
	}

	//Respuesta fallida sin data
	public void setFail(String message, String code) {
		this.setMessage(message);
		this.setCode(code);
		this.setState(Boolean.FALSE);
	}

	//Respuesta con error
	public void setFailError(String message, String code, String error) {
		this.setMessage(message);
		this.setError(error);
		this.setCode(code);
		this.setState(Boolean.FALSE);
	}
}
