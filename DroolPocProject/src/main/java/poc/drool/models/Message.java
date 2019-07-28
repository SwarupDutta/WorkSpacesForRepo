package poc.drool.models;

import java.util.ArrayList;
import java.util.List;

public  class Message {

    @Override
	public String toString() {
		return "Message [test=" + test + ", message=" + message + ", status=" + status + "]";
	}

	public static final int HELLO = 0;
    public static final int GOODBYE = 1;
 

	

	public List<String> getTest() {
		return test;
	}

	public void setTest(List<String> test) {
		this.test = test;
	}

	public List<String> test=new ArrayList<String>();

    private String message;

    private int status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}