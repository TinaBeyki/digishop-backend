/*
Hashing is the process of generating a string, or hash, from a given message using a mathematical function known as a
cryptographic hash function.

While there are several hash functions out there, those tailored to hashing passwords need to have four main properties
to be secure:

1.It should be deterministic: the same message processed by the same hash function should always produce the same hash
2.It's not reversible: it's impractical to generate a message from its hash
3.It has high entropy: a small change to a message should produce a vastly different hash
4.And it resists collisions: two different messages should not produce the same hash

Also, though, password hashing functions should be slow. A fast algorithm would aid brute force attacks in which a
hacker will attempt to guess a password by hashing and comparing billions (or trillions) of potential passwords per second.


Older implementations – such as SHAPasswordEncoder – would require the client to pass in a salt value when encoding
the password.
BCrypt, however, will internally generate a random salt instead. This is important to understand because it means that
 each call will have a different result, and so we need to only encode the password once.
To make this random salt generation work, BCrypt will store the salt inside the hash value itself. For instance, in the
following hash value: $2a$10$ZLhnHxdpHETcxmtEStgpI./Ri1mksgJ9iDP36FmfMdYyVg9g0b2dq


There are three fields separated by $:

The “2a” represents the BCrypt algorithm version
The “10” represents the strength of the algorithm
The “ZLhnHxdpHETcxmtEStgpI.” part is actually the randomly generated salt.
Basically, the first 22 characters are salt. The remaining part of the last field is the actual hashed version of the
plain text

Also, be aware that the BCrypt algorithm generates a String of length 60, so we need to make sure that the password will
be stored in a column that can accommodate it. A common mistake is to create a column of a different length and then get
 an Invalid Username or Password error at authentication time.

 */
package com.digishop.encryption;