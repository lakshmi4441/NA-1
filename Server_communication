import socket
host='72,36,65,67'
port=1994
s=socket.socket()
s.bind((host,port))
s.listen(1)
c,addr=s.accept()
while True:
  data=c.recv(1024)
    if data=='bye from Client':
        c.send('bye from Server')
        break
     elif data=='Hello from Client':
        print str(data)
        c.send('Hello from Server')
     else
        print str(data)
c.close()
