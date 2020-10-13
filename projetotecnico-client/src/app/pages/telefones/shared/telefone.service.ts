import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Telefone } from 'telefones.module';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
const apiUrl = './telefone.module';

@Injectable({
  providedIn: 'root'
})
export class TelefoneService {

  constructor(private http: HttpClient) { }

  getTelefones(): Observable<Telefone[]> {
    return this.http.get<Telefone[]>(apiUrl)
      .pipe(
        tap(telefones => console.log('leu os telefones')),
        catchError(this.handleError('getTelefones', []))
      );
  }

  getTelefone(id: number): Observable<Telefone> {
    const url = `${apiUrl}/${id}`;
    return this.http.get<Telefone>(url).pipe(
      tap(_ => console.log(`leu o telefone id=${id}`)),
      catchError(this.handleError<Telefone>(`getTelefone id=${id}`))
    );
  }

  addTelefone(telefone): Observable<Telefone> {
    return this.http.post<Telefone>(apiUrl, telefone, httpOptions).pipe(
      // tslint:disable-next-line:no-shadowed-variable
      tap((telefone: Telefone) => console.log(`adicionou o telefone com w/ id=${telefone.id}`)),
      catchError(this.handleError<Telefone>('addTelefone'))
    );
  }

  updateTelefone(id, telefone): Observable<any> {
    const url = `${apiUrl}/${id}`;
    return this.http.put(url, telefone, httpOptions).pipe(
      tap(_ => console.log(`atualiza o produco com id=${id}`)),
      catchError(this.handleError<any>('updateTelefone'))
    );
  }

  deleteTelefone(id): Observable<Telefone> {
    const url = `${apiUrl}/delete/${id}`;

    return this.http.delete<Telefone>(url, httpOptions).pipe(
      tap(_ => console.log(`remove o telefone com id=${id}`)),
      catchError(this.handleError<Telefone>('deleteTelefone'))
    );
  }

  private handleError<T>(deleteTelefone1: string, result?: T) {
    return (error: any): Observable<T> => {

      console.error(error);

      return of(result as T);
    };

}
