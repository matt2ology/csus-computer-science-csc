# CSC138_sec06_lab2_Matthew_Mendoza - Homework 3: Wireshark Lab: HTTPv7.0 (Intro to Computer Networks)

**Author:** Matthew Mendoza

**Course:** CSC 138

**Section:** 06

- [CSC138_sec06_lab2_Matthew_Mendoza - Homework 3: Wireshark Lab: HTTPv7.0 (Intro to Computer Networks)](#csc138_sec06_lab2_matthew_mendoza---homework-3-wireshark-lab-httpv70-intro-to-computer-networks)
  - [The Basic HTTP GET/response interaction](#the-basic-http-getresponse-interaction)
    - [1. Is your browser running HTTP version 1.0 or 1.1? What version of HTTP is the server running?](#1-is-your-browser-running-http-version-10-or-11-what-version-of-http-is-the-server-running)
    - [2. What languages (if any) does your browser indicate that it can accept to the server?](#2-what-languages-if-any-does-your-browser-indicate-that-it-can-accept-to-the-server)
    - [3. What is the IP address of your computer? Of the gaia.cs.umass.edu server?](#3-what-is-the-ip-address-of-your-computer-of-the-gaiacsumassedu-server)
    - [4. What is the status code returned from the server to your browser?](#4-what-is-the-status-code-returned-from-the-server-to-your-browser)
    - [5. When was the HTML file that you are retrieving last modified at the server?](#5-when-was-the-html-file-that-you-are-retrieving-last-modified-at-the-server)
    - [6. How many bytes of content are being returned to your browser?](#6-how-many-bytes-of-content-are-being-returned-to-your-browser)
    - [7. By inspecting the raw data in the packet content window, do you see any headers within the data that are not displayed in the packet-listing window? If so, name one](#7-by-inspecting-the-raw-data-in-the-packet-content-window-do-you-see-any-headers-within-the-data-that-are-not-displayed-in-the-packet-listing-window-if-so-name-one)
  - [2. The HTTP CONDITIONAL GET/response interaction](#2-the-http-conditional-getresponse-interaction)
    - [8. Inspect the contents of the first HTTP GET request from your browser to the server. Do you see an “IF-MODIFIED-SINCE” line in the HTTP GET?](#8-inspect-the-contents-of-the-first-http-get-request-from-your-browser-to-the-server-do-you-see-an-if-modified-since-line-in-the-http-get)
    - [9. Inspect the contents of the server response. Did the server explicitly return the contents of the file? How can you tell?](#9-inspect-the-contents-of-the-server-response-did-the-server-explicitly-return-the-contents-of-the-file-how-can-you-tell)
    - [10. Now inspect the contents of the second HTTP GET request from your browser to the server. Do you see an “IF-MODIFIED-SINCE:” line in the HTTP GET? If so, what information follows the “IF-MODIFIED-SINCE:” header?](#10-now-inspect-the-contents-of-the-second-http-get-request-from-your-browser-to-the-server-do-you-see-an-if-modified-since-line-in-the-http-get-if-so-what-information-follows-the-if-modified-since-header)
    - [11. What is the HTTP status code and phrase returned from the server in response to this second HTTP GET? Did the server explicitly return the contents of the file? Explain](#11-what-is-the-http-status-code-and-phrase-returned-from-the-server-in-response-to-this-second-http-get-did-the-server-explicitly-return-the-contents-of-the-file-explain)
  - [3. Retrieving Long Documents](#3-retrieving-long-documents)
    - [12. How many HTTP GET request messages did your browser send?Which packet number in the trace contains the GET message for the Bill or Rights?](#12-how-many-http-get-request-messages-did-your-browser-sendwhich-packet-number-in-the-trace-contains-the-get-message-for-the-bill-or-rights)
    - [13. Which packet number inthe trace contains the status code and phrase associated with the response to the HTTP GET request?](#13-which-packet-number-inthe-trace-contains-the-status-code-and-phrase-associated-with-the-response-to-the-http-get-request)
    - [14. What is the status code and phrase in the response?](#14-what-is-the-status-code-and-phrase-in-the-response)
    - [15. How many data-containing TCP segments were needed tocarry the single HTTP response and the text of theBill of Rights?](#15-how-many-data-containing-tcp-segments-were-needed-tocarry-the-single-http-response-and-the-text-of-thebill-of-rights)
  - [4. HTML Documents with Embedded Objects](#4-html-documents-with-embedded-objects)
    - [16. How many HTTP GET request messagesdid your browser send? To which Internet addresses were these GET requests sent?](#16-how-many-http-get-request-messagesdid-your-browser-send-to-which-internet-addresses-were-these-get-requests-sent)
    - [17. Can you tell whether your browser downloaded the two images serially, or whether they were downloaded from the two web sites in parallel? Explain](#17-can-you-tell-whether-your-browser-downloaded-the-two-images-serially-or-whether-they-were-downloaded-from-the-two-web-sites-in-parallel-explain)
  - [5. HTTP Authentication](#5-http-authentication)
    - [18. What is the server’s response (status code and phrase) in response to the initial HTTP GET message from your browser?](#18-what-is-the-servers-response-status-code-and-phrase-in-response-to-the-initial-http-get-message-from-your-browser)
    - [19. When your browser’s sends the HTTP GET message for the second time, what new field is included in the HTTP GET message?](#19-when-your-browsers-sends-the-http-get-message-for-the-second-time-what-new-field-is-included-in-the-http-get-message)

## The Basic HTTP GET/response interaction

### 1. Is your browser running HTTP version 1.0 or 1.1? What version of HTTP is the server running?

### 2. What languages (if any) does your browser indicate that it can accept to the server?

### 3. What is the IP address of your computer? Of the gaia.cs.umass.edu server?

### 4. What is the status code returned from the server to your browser?

### 5. When was the HTML file that you are retrieving last modified at the server?

### 6. How many bytes of content are being returned to your browser?

### 7. By inspecting the raw data in the packet content window, do you see any headers within the data that are not displayed in the packet-listing window? If so, name one

## 2. The HTTP CONDITIONAL GET/response interaction

### 8. Inspect the contents of the first HTTP GET request from your browser to the server. Do you see an “IF-MODIFIED-SINCE” line in the HTTP GET?

### 9. Inspect the contents of the server response. Did the server explicitly return the contents of the file? How can you tell?

### 10. Now inspect the contents of the second HTTP GET request from your browser to the server. Do you see an “IF-MODIFIED-SINCE:” line in the HTTP GET? If so, what information follows the “IF-MODIFIED-SINCE:” header?

### 11. What is the HTTP status code and phrase returned from the server in response to this second HTTP GET? Did the server explicitly return the contents of the file? Explain

## 3. Retrieving Long Documents

### 12. How many HTTP GET request messages did your browser send?Which packet number in the trace contains the GET message for the Bill or Rights?

### 13. Which packet number inthe trace contains the status code and phrase associated with the response to the HTTP GET request?

### 14. What is the status code and phrase in the response?

### 15. How many data-containing TCP segments were needed tocarry the single HTTP response and the text of theBill of Rights?

## 4. HTML Documents with Embedded Objects

### 16. How many HTTP GET request messagesdid your browser send? To which Internet addresses were these GET requests sent?

### 17. Can you tell whether your browser downloaded the two images serially, or whether they were downloaded from the two web sites in parallel? Explain

## 5. HTTP Authentication

### 18. What is the server’s response (status code and phrase) in response to the initial HTTP GET message from your browser?

### 19. When your browser’s sends the HTTP GET message for the second time, what new field is included in the HTTP GET message?
