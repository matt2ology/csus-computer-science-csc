#!/usr/bin/env python3
# import socket module
import socket
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
    local_host = gethostbyname(gethostname())
    # Prepare a sever socket
    port_number = 65432  # Port to listen on (non-privileged ports are > 1023)
    logging.info("To be bind: " + str(local_host) + ":" + str(port_number))
    serverSocket.bind((local_host, port_number))
    serverSocket.listen(1)
    logging.info("The server is ready to receive")
    while True:
        # Establish the connection
        logging.info('Ready to serve...')
        connection_socket, addr = serverSocket.accept()
        try:
            logging.info("Connecting to server at " +
                         str(addr[0]) + " on port " + str(port_number))
            message = connection_socket.recv(1024)
            file_name = message.split()[1]
            file = open(file_name[1:])
            output_data = file.read()
            # Send one HTTP header line into socket
            http_header = "HTTP/1.1 200 OK \r\n\r\n"
            connection_socket.send(http_header.encode())
            # Send the content of the requested file to the client
            for i in range(0, len(output_data)):
                connection_socket.send(output_data[i].encode())
            connection_socket.close()
        except IOError:
            # Send response message for file not found
            connection_socket.send("HTTP/1.1 200 OK \r\n\r\n".encode())
            connection_socket.sendall(
                "HTTP/1.1 404 Not Found \r\n\r\n".encode())
            # Close client socket
            connection_socket.close()
        connection_socket.close()


if __name__ == '__main__':
    main()
