## This repo has samples of two API services using 'Spring Cloud Contract' for contract testing.

Consumer: An API which calculates the grade for a student given scores of 3 subject groups (PCM, PCB,PCMIT) P=> Physics, C=>Chemistry, M=>Maths, IT=>Information Technology.

Producer: An API that returns the maximum of 3 values given 3 numbers.

Steps for Contract based testing:
1. Consumer writes the contract.
2. Contract is shared with the Producer.
3. Producer generates failing tests to fulfill the contract.
4. Producer makes the test pass.
5. When all the contract tests ( and any other unit / integration test pass) the stubs generated based on the contract are pushed to a common repository / artefactory.
6. The consumer uses the Stubs to test the consumer side API.
7. If there is a deviation in the parameters mentioned in the contract from the consumer or the producer then these tests start failing.
8. This prevents the producer from pushing a build which has all unit / integration tests passing (against an old definitaion) and then fail on production because the interface mocks were not updated. (Maybe this last sentence needs re-workding)
