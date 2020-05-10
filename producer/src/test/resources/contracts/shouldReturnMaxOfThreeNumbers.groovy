package contracts

import org.springframework.cloud.contract.spec.Contract;

Contract.make{
    request {
        method 'POST'
        url '/max-number'
        body """
            {
                "number1" : 1,
                "number2" : 2,
                "number3" : 3
            }
            """
        headers {
            contentType applicationJson()
        }
    }
    response {
        status 200
        body """
            {
                "maxNumber" : "3" 
            }
            """
        headers {
            contentType applicationJson()
        }
    }

}