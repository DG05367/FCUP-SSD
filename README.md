
# Public Ledger for Auctions
### System and Data Security 22/23


**This assignment requires the implementation of a public blockchain (non-permissioned), but opposite to Bitcoin and Ethereum, the purpose here is to have a decentralized public ledger capable of storing auction transactions.**

##  The work is divided into 3 parts, distributed ledger, secure P2P and auction mechanisms:
1. The secure ledger should be modular, and it must support PoW and Delegated Proof-ofStake (DPoS) (configurable) as the core consensus:

    – using proof-of-work and,

    – Proof-of-stake. The reputation mechanisms from be integrated here.


2. A P2P layer to gossip the necessary data to support the blockchain that must include :

    – must implement Kademlia

    – Resistance to Sybil and Eclipse attacks

    – Implement trust mechanisms. To be integrated in proof-of-stake.


3. An auction system capable of supporting sellers and buyers using a single attribute auction following the English auction:

    – Transactions should be saved in the blockchain (using public key crypto)

    – A publisher/subscriber should be built on top of Kademlia to suport auctions.


• Mandatory report with a maximum of 6 pages (with unlimited pages for references), A4,
fontsize 11, using latex.

• The architecture must be clearly presented, with the design choices being driven by the
functional requirements (presented above). It also must present the assumptions made,
namely mandated by theoretical and practical limitations.

## The expected outcomes are the following:
• Design and implementation of the system, with security as a first-class citizen. This means that
identity, authorization, authentication, access control and trust/authoritativedomains must
be addressed. Beware of the communications channels and crypto you use; besure they fit
your needs. The codebase must be hosted in a private repository in Github or Bitbucket.
