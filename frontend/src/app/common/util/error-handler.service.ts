import {Injectable} from "@angular/core";
import {HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";

@Injectable()
export class ErrorHandlerService {
    validationError = 422;

    constructor(private router: Router) {

    }

    handleHttpError(error: HttpErrorResponse) {

        if (error.status == this.validationError){
            alert("Please provide all fields and try again!")
            //honestly, its 5:37 in the morning. I'm done :P
        } else {
            this.router.navigate(['not-found']);
        }

    }
}
