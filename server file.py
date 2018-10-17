import socket
host=''
port=1994
s=socket.socket()
s.bind((host,port))
s.listen(1)
c,addr=s.accept()
while True:
      data=c.recv(1024)
      if data=='exit':
            c.send('server gone')
            break
      else
            k=open('lakshmi1.txt','w')
            k.write(data)
            k.close()
            print str(data)
            c.send(data+'\nAdded by the server')
c.close()
