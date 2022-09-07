package io;

public interface IMessageHandler
{
    void onConnectOK();
    
    void onConnectionFail();
    
    void onDisconnected();
    
    void onMessage(final Message p0);
}
