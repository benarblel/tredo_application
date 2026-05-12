import { Card } from './card';

export interface CardList {
    id: number;
    name: string;
    position: number;
    cards: Card[];
}