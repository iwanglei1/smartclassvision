netsh advfirewall firewall add rule name=Batch protocol=TCP dir=out remoteport=80,8080,443,995,9100,23,25 action=block