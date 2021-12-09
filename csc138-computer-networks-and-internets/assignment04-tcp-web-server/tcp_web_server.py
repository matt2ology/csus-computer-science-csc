#!/usr/bin/env python3
# import socket module
from socket import *
import logging
FORMAT = '[%(asctime)s]-[%(funcName)s]-[%(levelname)s] - %(message)s'
logging.basicConfig(
    level=logging.INFO,
    format=FORMAT
)

def main():
    # Create a TCP server socket
    # (AF_INET is used for IPv4 protocols)
    # (SOCK_STREAM is used for TCP)
    serverSocket = socket(AF_INET, SOCK_STREAM)
    HOST = '127.0.1.1'  # Standard loopback interface address (localhost)
    # Prepare a sever socket
    PORT  = 65432 # Port to listen on (non-privileged ports are > 1023)
    # Fill in start
    serverSocket.bind((HOST, PORT ))
    serverSocket.listen(1)
    # Fill in end
    while True:
        # Establish the connection
        logging.info('Ready to serve...')
        connectionSocket, addr = serverSocket.accept()
        try:
            logging.info("Connecting to server at " + addr + " on port " + str(PORT))
            message = connectionSocket.recv(1024)  # Fill in start #Fill in end
            filename = message.split()[1]
            f = open(filename[1:])
            outputdata = f.read()  # Fill in start #Fill in end
            # Send one HTTP header line into socket
            # Fill in start
            connectionSocket.send('HTTP/1.1 200 OK \r\n\r\n'.encode())
            # Fill in end
            # Send the content of the requested file to the client
            for i in range(0, len(outputdata)):
                connectionSocket.send(outputdata[i].encode())
            connectionSocket.close()
        except IOError:
            # Send response message for file not found
            # Fill in start
            connectionSocket.send(
                "HTTP/1.1 200 OK  \r\n\r\n 404 Not Found".encode())
            # Fill in end
            # Close client socket
            # Fill in start
            connectionSocket.close()


if __name__ == '__main__':
    main()
