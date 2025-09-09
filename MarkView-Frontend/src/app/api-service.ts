import {inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {tap} from "rxjs";

type Markdown = {
    id: number;
    fileName: string;
    content: string;
    createdAt: string; // ISO 8601 formatted date-time string
};

type HtmlDoc={
    message:string;
    html:string;
}

@Injectable({
  providedIn: 'root'
})
export class ApiService {
    private _id: number | undefined;

  private _httpClient = inject(HttpClient);
  upload (formData:FormData){
   return  this._httpClient.post<Markdown>("http://localhost:8080/api/upload",formData,{
     observe:"body"
   }).pipe(
       tap(body=> {
           this._id = body.id
           console.log(this._id)
       })
   )
  }

  convert(){
   return   this._httpClient.get<HtmlDoc>(`http://localhost:8080/api/convert/${this._id}`).pipe(
          tap(body=>console.log(body))
      )
  }

}

