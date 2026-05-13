import { TestBed } from '@angular/core/testing';

import { CardList } from './card-list';

describe('CardList', () => {
  let service: CardList;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardList);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
