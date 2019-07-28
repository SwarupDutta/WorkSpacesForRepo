from weblogic.security.internal import *
from weblogic.security.internal.encryption import *
encryptionService = SerializedSystemIni.getEncryptionService(".")
clearOrEncryptService = ClearOrEncryptedService(encryptionService)
pwd = raw_input("Paste encrypted password ({AES}fk9EK...): ")
preppwd = pwd.replace("\\", "")
print "Decrypted string is: " + clearOrEncryptService.decrypt(preppwd)
