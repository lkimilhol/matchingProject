package com.lkimilhol.matchingProject.response;

import com.lkimilhol.matchingProject.exception.ErrorInfo;
import org.springframework.http.HttpStatus;

public class ResultBody {
    private int serverCode;
    private String serverMsg;
    private Object results;

    public ResultBody(ErrorInfo errorInfo) {
        this.serverCode = errorInfo.getErrorCode();
        this.serverMsg = errorInfo.getErrorMessage();
    }

    public ResultBody() {
        this.serverCode = ErrorInfo.SUCCESS.getErrorCode();
        this.serverMsg = ErrorInfo.SUCCESS.getErrorMessage();
    }

    public ResultBody(Object results) {
        this.serverCode = ErrorInfo.SUCCESS.getErrorCode();
        this.serverMsg = ErrorInfo.SUCCESS.getErrorMessage();
        this.results = results;
    }

    public int getServerCode() {
        return serverCode;
    }

    public void setServerCode(int serverCode) {
        this.serverCode = serverCode;
    }

    public String getServerMsg() {
        return serverMsg;
    }

    public void setServerMsg(String serverMsg) {
        this.serverMsg = serverMsg;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }
}
