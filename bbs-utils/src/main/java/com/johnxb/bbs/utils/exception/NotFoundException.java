package com.johnxb.bbs.utils.exception;

public class NotFoundException extends Exception{
    /**
     * errorCode
     */
    private String errorCode;

    public NotFoundException() {
        super();
    }

//    /**
//     * 传Message类型
//     * @param message
//     */
//    public BusinessException(Message message) {
//        super(message.toString());
//        this.errorCode = message.getCode();
//    }

    /**
     * 直接传错误消息
     * @param message
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * 获取errorCode
     * @return
     */
    public String getErrorCode() {
        return this.errorCode;
    }
}
