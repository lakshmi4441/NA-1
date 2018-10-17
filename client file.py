import socket
host='72,36,65,67'
port=1994
s=socket.socket()
s.connect((host,port))
m==raw_input("Press enter-->")
g=open('lakshmi.txt',rb')
n=g.read()
while True:
     if m=='exit':
        s.send(m)
        data=s.recv(1024)
        print str(data)
        break
    else
        s.send(n)
        data=s.recv(1024)
        print str(data)
        m=raw_input()
s.close()
