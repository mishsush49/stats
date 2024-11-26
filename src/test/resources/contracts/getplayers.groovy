package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description "should return Player by id=1"

    request {
        url "/api/players"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body(
                file("files/allPlayers.json")
        )
    }
}