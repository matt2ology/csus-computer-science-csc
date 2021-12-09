# CSC138_sec06_ASSIGNMENT7_Matthew_Mendoza - ASSIGNMENT 7: 2-4 pages report

Author: Matthew Mendoza

Course: CSC 138

Section: 06

- [CSC138_sec06_ASSIGNMENT7_Matthew_Mendoza - ASSIGNMENT 7: 2-4 pages report](#csc138_sec06_assignment7_matthew_mendoza---assignment-7-2-4-pages-report)
  - [The Struggle For A Better Connected Smart Home](#the-struggle-for-a-better-connected-smart-home)
    - [Abstract](#abstract)
    - [Introduction](#introduction)
    - [Methods](#methods)
    - [Conclusion](#conclusion)
  - [References](#references)

## The Struggle For A Better Connected Smart Home

### Abstract

Look for devices utilizing Zigbee or Z-wave when building out your smart home
for both power efficiency and range.

### Introduction

Post 2007 one's smart phone is most likely to support WiFi, Bluetooth, and some kind of cellular connection. He or she may believe that his or her smartphone has all the important wireless protocol the tech industry has to offer.

Enter Zigbee and Z-wave: two technologies targeted for home automation (Smart Home) applications where low power consumption and longer signal range are desired.

### Methods

One of the main advantage of smart devices built on Zigbee and Z-wave, unlike WiFi, protocols is in their power consumption. WiFi, although versatile, consumes a lot of power as it is built for bandwidth heavy applications like streaming movies and online gaming, but one does not need a lot of bandwidth to signal the garage door to close, command the smart light bulb to switch from white to the colors of the rainbow, or have the end device signal to the base station that a window is open or not.

Both Zigbee and Z-wave operate at speeds below 300 kilobit (Zigbee at 250 kilobits per second [kbit/s] and Z-wave at 100 kilobits per second [kbit/s]), not much faster than 90's dial-up speeds, but what they lack in transfer speed the resulting power savings far outweighs the con of slow data/information transfer speeds; equally important, the targeted smart home devices, that Zigbee and Z-wave are designed for, are often placed in locations where there few or no power outlets and may potentially need to last for a long time without a change in batteries or require frequent recharging (devices like motion sensors).

One may consider Bluetooth Smart Home devices as an alternative to WiFi based solutions, but he or she will quickly find out that as they get further from the base station his or her connection strength drops; for this reason, this is another advantage that both Zigbee and Z-wave have over the familiar Bluetooth, both Zigbee and Z-wave, are designed to operate as "mesh networks" where each device acts as a node to send the signal on to the target device (a lot like how the internet works).

Although both Zigbee and Z-wave share a lot of similarities, in power efficiency and device range, the difference between the two (Zigbee and Z-wave) is that in Z-wave operates on a lower frequency, 908 megahertz (HMz), enabling greater distances between nodes (Z-wave hub or Z-wave enabled devices); on the other hand, Zigbee operates on the more conventional 2400 megahertz (HMz), 2.4 GHz (same as many WiFi routers), bandwidth but allows Zigbee enabled devices to have a signal jump though as many Zigbee nodes to reach the signal's destination. On the Z-wave platform a signal may only jump though as many as four Z-wave devices to reach it's destination, so one be more strategic and mindful to what kind of floor plan he or she lives in or plan to live in.

### Conclusion

In conclusion, when building out the ultimate wireless connected smart home be mindful to which protocols the smart device is built on, its power consumption, its ability to transmit a signal, and the floor plan. One maybe tempted to invest on smart devices that utilize WiFi or Bluetooth, but WiFi draws a lot of power for data transfer speed smart devices do not need and Bluetooth lacks the ability to transmit signals over relatively long distances.

Investing into either Zigbee or Z-wave, technologies tailored and designed for smart homes application and devices, one would have to keep in mind of his or her living space; for, if he or she lives in large floor plan Z-wave may not be the best platform to invest for a signal may only jump four times between it's source to the signal's target destination. On the other hand Zigbee maybe problematic for it operates on the same, congested, bandwidth his or her home WiFi operates, but does not have to worry about signal's ability to reach it's target destination.

## References

- Matter (formerly Project Connected Home over IP): <https://buildwithmatter.com/>
- Zigbee: <https://zigbeealliance.org/solution/zigbee/>
- Z-wave: <https://www.z-wave.com/>
- Bluetooth: <https://www.bluetooth.com/>
- CNET - Apple, Amazon and Google, oh my! Why the Matter Protocol Matters:
  - <https://www.youtube.com/watch?v=PjzQybNcHos&ab_channel=CNET>
- The Verge - How to make a smart home for $200:
  - <https://www.youtube.com/watch?v=1T9JvRXE13M&ab_channel=TheVerge>
