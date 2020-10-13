import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, flatMap } from 'rxjs/operators';
import {Endereco} from './enderecos.module';


@Injectable({
  providedIn: 'root'
})
export class EnderecoService {

  private apiPath = 'api/endereco';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Endereco[]> {
    return this.http.get(this.apiPath).pipe(
      catchError(this.handleError),
      map(this.jsonDataToEnderecos)
    );
  }

  getById( id: number ): Observable<Endereco> {
    const url = `${this.apiPath}/${id}`;

    return this.http.get(this.apiPath).pipe(
      catchError( this.handleError ),
      map( this.jsonDataToEndereco )
    );
  }

  private jsonDataToEnderecos( jsonData: any[] ): Endereco[] {
    const enderecos: Endereco[] = [];
    jsonData.forEach( element => enderecos.push(element as Endereco) );
    return enderecos;
  }

  private jsonDataToEndereco(jsonData: any): Endereco {
    return jsonData as Endereco;
  }

  private handleError( error: any ): Observable<any>{
    console.log( 'ERRO NA REQUISIÇÃO =>', error );
    return throwError( error );
  }

}
