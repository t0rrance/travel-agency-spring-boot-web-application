import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateOrderDetailsComponent } from './create-order-details.component';

describe('CreateOrderDetailsComponent', () => {
  let component: CreateOrderDetailsComponent;
  let fixture: ComponentFixture<CreateOrderDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateOrderDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateOrderDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
