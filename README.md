# PQGGenerator
Generator of security parameters(p q g) of cyclic group, a Java simple implementation of Schnorr Group(https://en.wikipedia.org/wiki/Schnorr_group)

```
* generate security parameters p q g of cyclic group G, G is a subgroup of multiplicative group Zp*
* p is a big prime number, q is a big prime number, and q | (p - 1), g is the generator
* This method is a implementation of Schnorr Group(https://en.wikipedia.org/wiki/Schnorr_group), you can get a designated p_bit and q_bit parameters
* For security, p is recommended (1024-3072bits) and q is recommended (160-256bits)
* Since p is generated from p, so may be p's bit length is not exactly as what you set, try more times!
* @param p_bits, p's length in bit
* @param q_bits, q's length in bit
```
