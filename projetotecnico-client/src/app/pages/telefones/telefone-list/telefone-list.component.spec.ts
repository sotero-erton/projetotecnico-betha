import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelefoneListComponent } from './telefone-list.component';

describe('TelefoneListComponent', () => {
  let component: TelefoneListComponent;
  let fixture: ComponentFixture<TelefoneListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TelefoneListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TelefoneListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
