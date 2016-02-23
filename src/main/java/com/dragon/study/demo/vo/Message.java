package com.dragon.study.demo.vo;


import com.dragon.study.demo.constant.Constant;

public class Message {
	
	//状态标识0为成功
	protected int status= Constant.STATUS_OK;
	//错误消息
	protected String msg; 

    public Message() {
    }
    
	public Message(int status) {
		this.status=status;
	}
	
	public Message(int status, String msg) {
		this.status=status;
		this.msg=msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
