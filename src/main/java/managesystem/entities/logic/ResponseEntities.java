package managesystem.entities.logic;

import java.io.Serializable;

public class ResponseEntities<T> implements Serializable {
    private Boolean isSuccess;
    private T reply;
    private Integer message_code;

    public ResponseEntities(Boolean isSuccess, T reply, Integer message_code) {
        this.isSuccess = isSuccess;
        this.reply = reply;
        this.message_code = message_code;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public T getReply() {
        return reply;
    }

    public void setReply(T reply) {
        this.reply = reply;
    }

    public Integer getMessage_code() {
        return message_code;
    }

    public void setMessage_code(Integer message_code) {
        this.message_code = message_code;
    }

    @Override
    public String toString() {
        return "ResponseEntities{" +
                "isSuccess=" + isSuccess +
                ", reply=" + reply +
                ", message_code=" + message_code +
                '}';
    }
}
