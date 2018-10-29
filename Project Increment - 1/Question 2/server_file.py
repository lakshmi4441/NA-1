import socket
import os
host = ''
port=5000
s=socket.socket()
s.bind((host,port))
s.listen(1)
c,addr=s.accept()
while True:   
      data = c.recv(1024)
      if data=='exit':
          c.send('server gone')
          break
      else:
          k = open('index.txt','w')
          k.write(data)
          k.close()
          print str(data)
          c.send(data+'\n added by the server')
c.close()
