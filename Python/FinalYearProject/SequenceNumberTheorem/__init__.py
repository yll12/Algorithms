from SequenceNumber import Seq
import math

x = Seq()
    
a = [5, 6, 3, 4]
u = x.seq_number(a)
print "coding the sequence, [" + ", ".join(map(str, a)) + "], we found u=" + str(u)

print "R(u) is :" + str(x.R(u))
print "L(u) is :" + str(x.L(u))

print "Now the claim is that S(i, u) = a_i, and we find that:"

result = []
for i in range (1, len(a) + 1):
    print "S(" + str(i) + ", u) are " + str(int(x.S(i, u))); 
