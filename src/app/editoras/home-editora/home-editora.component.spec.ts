import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeEditoraComponent } from './home-editora.component';

describe('HomeEditoraComponent', () => {
  let component: HomeEditoraComponent;
  let fixture: ComponentFixture<HomeEditoraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeEditoraComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeEditoraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
