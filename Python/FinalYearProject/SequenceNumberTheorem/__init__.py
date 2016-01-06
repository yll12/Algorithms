from SequenceNumber import Seq

x = Seq()

for i in range(10):
    print "T(" + str(i) + ") " + "is :" + str(x.T(i))

for i in range(1, 16):
    print "find_pair(" + str(i) + ") " + "is :" + str(x.find_pair(i))
    print "L(" + str(i) + ") " + "is :" + str(x.L(i))
    print "R(" + str(i) + ") " + "is :" + str(x.R(i))
    
for u in range(45, 50):
    for i in range(1, 15):
        print "S(" + str(i) +"," + str(u) + ") " + "is :" + str(x.S(i, u))

a = [1, 5, 3, 4]
u = x.seq_number(a)
print "u for [" + ", ".join(map(str, a)) + "] are: " + str(u)

result = []
for i in range (1, len(a) + 1):
    result.append(x.S(i, u))

print "R(" + str(u) + ") " + "is :" + str(x.R(u))
print "sequence for u are [" + ", ".join(map(str, result))  + "]" 

