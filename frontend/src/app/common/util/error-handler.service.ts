import {Injectable} from "@angular/core";
import {HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";

@Injectable()
export class ErrorHandlerService {

    constructor(private router: Router) {

    }

    handleHttpError(error: HttpErrorResponse) {
        this.router.navigate(['not-found']);
    }
}
