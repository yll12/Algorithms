'''
Created on Jan 6, 2016

@author: Acer
'''

class Seq(object):

    def __init__(self):
        pass
        
    def T(self, n):
        return n * (n + 1) / 2
    
    def P(self, x, y):
        return self.T(x + y - 2) + y
    
    def find_pair(self, z):
        if (z <= 0):
            raise Exception('z must be positive integer')
        n = 0
        done = False
        while (not done):
            T_n = self.T(n)
            if (T_n < z <= (T_n + n + 1)):
                done = True
            else:
                n += 1
        y = z - self.T(n)
        x = n - y + 2
        return (x, y)
        
    def L(self, z):
        return self.find_pair(z)[0]
    
    def R(self, z):
        return self.find_pair(z)[1]
    
    def S(self, i, u):
        return self.L(u) % (1 + i * self.R(u))

    def seq_number(self, list_a):
        N = len(list_a)
        y = self.__find_y(list_a, N)
        list_y = []
        for i in range(1, N + 1):
            list_y.append(1 + i * y)
        x = self.chinese_remainder(list_y, list_a)
        u = self.P(x, y)
        return u

    def __find_y(self, a_list, N):
        k = max(a_list)
        done = False
        while (not done):
            if (self.__divides_all(k, N)):
                return k
            else:
                k += 1
        return k
    
    def __divides_all(self, k, N):
        for i in range(1, N + 1):
            if (k % i != 0):
                return False
        return True
    
    def chinese_remainder(self, n, a):
        sum_ = 0
        prod = reduce(lambda a, b: a * b, n)
 
        for n_i, a_i in zip(n, a):
            p = prod / n_i
            sum_ += a_i * self.mul_inv(p, n_i) * p
        return sum_ % prod
 
    def mul_inv(self, a, b):
        b0 = b
        x0, x1 = 0, 1
        if b == 1: return 1
        while a > 1:
            q = a / b
            a, b = b, a % b
            x0, x1 = x1 - q * x0, x0
        if x1 < 0: x1 += b0
        return x1
 
