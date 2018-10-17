import socket
host='72,36,65,67'
port=1994
s=socket.socket()
s.connect((host,port))
m=raw_input("enter==>")
while True:
  if m=='Bye from Client':
    s.send(m)
    data=s.recv(1024)
    print str(data)
    break
    m=raw_input()
 elif m=='Hello from Client':
    s.send(m)
    data=s.recv(1024)
    print str(data)
    m==raw_input()
 else
    s.send(m)
    data=s.recv(1024)
    print str(data)
s.close()
