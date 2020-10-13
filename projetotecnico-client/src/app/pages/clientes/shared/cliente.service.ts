import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, flatMap } from 'rxjs/operators';

import { Cliente } from './cliente.model';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private apiPath = 'api/clientee';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Cliente[]> {
    return this.http.get(this.apiPath).pipe(
      catchError(this.handleError),
      map(this.jsonDataToClientes)
    );
  }

  getById( id: number ): Observable<Cliente> {
    const url = `${this.apiPath}/${id}`;

    return this.http.get(this.apiPath).pipe(
      catchError( this.handleError ),
      map( this.jsonDataToCliente )
    );
  }

  private jsonDataToClientes( jsonData: any[] ): Cliente[] {
    const clientes: Cliente[] = [];
    jsonData.forEach( element => clientes.push(element as Cliente) );
    return clientes;
  }

  private jsonDataToCliente(jsonData: any): Cliente {
    return jsonData as Cliente;
  }

  private handleError( error: any ): Observable<any>{
    console.log( 'ERRO NA REQUISIÇÃO =>', error );
    return throwError( error );
  }

}
