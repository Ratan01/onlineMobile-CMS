package com.cg.oma.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseInfo {
	private int status;
    private String acknowledgement;
    private String message;
    private String path;
	public ResponseInfo(int status, String acknowledgement, String message, String path) {
		super();
		this.status = status;
		this.acknowledgement = acknowledgement;
		this.message = message;
		this.path = path;
	}
	public ResponseInfo() {
		super();
	}
}
