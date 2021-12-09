# CSC138_sec06_ASSIGNMENT3_Matthew_Mendoza - ASSIGNMENT 3: Socket Progrmming SMTP

Author: Matthew Mendoza

Course: CSC 138

Section: 06

- [CSC138_sec06_ASSIGNMENT3_Matthew_Mendoza - ASSIGNMENT 3: Socket Progrmming SMTP](#csc138_sec06_assignment3_matthew_mendoza---assignment-3-socket-progrmming-smtp)
  - [Code For SMTP Mail Client](#code-for-smtp-mail-client)
  - [Received E-Mail Message](#received-e-mail-message)

## Code For SMTP Mail Client

```python
#! python3
'''
CSC138_sec06_ASSIGNMENT3_Matthew_Mendoza: Socket Progrmming Assignment 3: SMTP
author: Matthew Mendoza
'''

import time
from socket import *

import logging
FORMAT = '[%(asctime)s]-[%(funcName)s]-[%(levelname)s] - %(message)s'
logging.basicConfig(
    level=logging.INFO,
    format=FORMAT
)


def main():
    msg = "\r\n I love Computer Networks"
    endmsg = "\r\n.\r\n"

    # need to use smtp4dev and run that on localhost
    mailserver = ("gaia.ecs.csus.edu", 25)

    # Create socket called clientSocket and establish a TCP connection with mailserver
    clientSocket = socket(AF_INET, SOCK_STREAM)
    clientSocket.connect(mailserver)

    recv = clientSocket.recv(1024)
    recv = recv.decode()
    logging.info("Message after connection request:" + recv)
    if recv[:3] != '220':
        logging.warning("220 reply not received from server.")

    # Send HELO command and print server response.
    heloCommand = 'HELO Alice\r\n'
    clientSocket.send(heloCommand.encode())
    recv1 = clientSocket.recv(1024)
    recv1 = recv1.decode()
    print(recv1)
    if recv1[:3] != '250':
        logging.warning("250 reply not received from server.")

    # Send MAIL FROM command and print server response.
    mailFrom = "MAIL FROM: <student_name@ecs.csus.edu>\r\n"
    clientSocket.send(mailFrom.encode())
    recv2 = clientSocket.recv(1024)
    recv2 = recv2.decode()
    logging.info("After MAIL FROM command: " + recv2)
    if recv1[:3] != '250':
        logging.warning("250 reply not received from server.")

    # Send RCPT TO command and print server response.
    rcptTo = "RCPT TO: <student_name@csus.edu>\r\n"
    clientSocket.send(rcptTo.encode())
    recv3 = clientSocket.recv(1024)
    recv3 = recv3.decode()
    logging.info("After RCPT TO command: " + recv3)
    if recv1[:3] != '250':
        logging.warning("250 reply not received from server.")

    # Send DATA command and print server response.
    data = "DATA\r\n"
    clientSocket.send(data.encode())
    recv4 = clientSocket.recv(1024)
    recv4 = recv4.decode()
    logging.info("After DATA command: " + recv4)
    if recv1[:3] != '250':
        logging.warning("250 reply not received from server.")

    # Send message data.
    subject = "Subject: SMTP mail client testing\r\n\r\n"
    clientSocket.send(subject.encode())
    date = time.strftime("%a, %d %b %Y %H:%M:%S", time.gmtime())
    date = date + "\r\n\r\n"
    clientSocket.send(date.encode())
    clientSocket.send(msg.encode())
    clientSocket.send(endmsg.encode())
    recv_msg = clientSocket.recv(1024)
    logging.info("Response after sending message body: " + recv_msg.decode())
    if recv1[:3] != '250':
        logging.warning("250 reply not received from server.")

    # Send QUIT command and get server response.
    clientSocket.send("QUIT\r\n".encode())
    message = clientSocket.recv(1024)
    print(message.decode())
    clientSocket.close()


if __name__ == '__main__':
    main()

```

## Received E-Mail Message

![Screenshot 2021-11-30 215403.png](Screenshot%202021-11-30%20215403.png)
