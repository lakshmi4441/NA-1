import socket
host = ''
port=1997
s=socket.socket()
s.bind((host,port))
s.listen(1)
c,addr=s.accept()
while True:
    data=c.recv(1024)
    if data=='Bye from Client':
      c.send('Bye from Server')
       break
    elif data=='Hello from Client':
        print str(data)
        c.send('Hello from Server')
    else:
        print str(data)
        c.send(data)
c.close()
