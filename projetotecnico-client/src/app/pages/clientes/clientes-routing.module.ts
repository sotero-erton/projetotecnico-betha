import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ClientesListComponent} from './clientes-list/clientes-list.component';
import {LoginComponent} from './login/login.component';
import {ClientesFormComponent} from './clientes-form/clientes-form.component';

const routes: Routes = [
  { path: '', component: LoginComponent},
  { path: 'clientes', component: ClientesListComponent},
  { path: 'clientes/new', component: ClientesFormComponent},
  { path: 'clientes/:id/edit', component: ClientesFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientesRoutingModule { }
