package lk.home.kulunu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;




@Component
public class ResponseMessage implements Serializable {

    private static final long serialVersionUID = 4557651712310010802L;

    private Object data;
    private String error;
    //private String success;
    private int statusCode;


    public ResponseMessage() {
    }

    public ResponseMessage(Object data, String error, int statusCode) {
        this.data = data;
        this.error = error;
        this.statusCode = statusCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "data=" + data +
                ", error='" + error + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}