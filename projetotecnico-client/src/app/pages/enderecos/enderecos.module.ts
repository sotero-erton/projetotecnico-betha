import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EnderecosRoutingModule } from './enderecos-routing.module';
import { EnderecoFormComponent } from './endereco-form/endereco-form.component';
import { EnderecoListComponent } from './endereco-list/endereco-list.component';


@NgModule({
  declarations: [EnderecoFormComponent, EnderecoListComponent],
  imports: [
    CommonModule,
    EnderecosRoutingModule
  ]
})
export class EnderecosModule { }
