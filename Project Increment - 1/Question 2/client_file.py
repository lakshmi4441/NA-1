import socket
host = ''
port = 5000
s=socket.socket()
s.connect((host,port))
m=raw_input("press enter-->")
g=open('welcome.txt','rb')
n=g.read()
while True:
  if m=='exit':
    s.send(m)
    data=s.recv(1024)
    print str(data)
    break
 else: 
    s.send(n)
    data=s.recv(1024)
    print str(data)
    m=raw_input()
s.close()
