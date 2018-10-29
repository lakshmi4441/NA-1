import socket
host = '10.205.1.232'
port = 1997
s=socket.socket()
s.connect((host,port))
m=raw_input("enter -->")

whileTrue:
  if m == 'Bye from Client':
    s.send(m)
    data=s.recv(1024)
    print str(data)
    break
    m=raw_input()
 elif m == 'Hello from Client':
  s.send(m)
  data=s.recv(1024)
  print str(data)
  m=raw_input()
else:
  s.send(m)
  data=s.recv(1024)
  print str(data)
  
s.close()
