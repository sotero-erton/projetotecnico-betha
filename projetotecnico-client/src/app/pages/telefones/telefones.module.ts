import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TelefonesRoutingModule } from './telefones-routing.module';
import { TelefoneFormComponent } from './telefone-form/telefone-form.component';
import { TelefoneListComponent } from './telefone-list/telefone-list.component';


@NgModule({
  declarations: [TelefoneFormComponent, TelefoneListComponent],
  imports: [
    CommonModule,
    TelefonesRoutingModule
  ]
})
export class TelefonesModule { }
