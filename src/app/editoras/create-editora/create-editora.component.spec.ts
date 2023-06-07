import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateEditoraComponent } from './create-editora.component';

describe('CreateEditoraComponent', () => {
  let component: CreateEditoraComponent;
  let fixture: ComponentFixture<CreateEditoraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateEditoraComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateEditoraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
