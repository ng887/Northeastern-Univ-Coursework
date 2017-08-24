const eventItems = [
    { id: 0, date: 'Feb-27', time: '03:00 PM', title: 'Immigration executive orders', parentId: 'item-00' },
    { id: 1, date: 'Feb-27', time: '05:00 PM', title: 'Public Reading by Neel Mukherjee', parentId: 'item-00' },
    { id: 2, date: 'Feb-27', time: '05:30 PM', title: 'On-fire to Hire startup Expo', parentId: 'item-00' },
    { id: 3, date: 'Mar-11', time: '10:00 AM', title: 'Work of Honor – Networking Event', parentId: 'item-01' },
    { id: 4, date: 'Mar-12', time: '05:00 PM', title: 'The Natural Language Processing (NLP) Meet-up', parentId: 'item-01' },
    { id: 5, date: 'Mar-18', time: '09:00 AM', title: 'Huge Book Sale at Seattle Center', parentId: 'item-01' },
    { id: 6, date: 'Mar-11', time: '10:00 aM', title: 'Security & Resilience Program ', parentId: 'item-02' },
    { id: 7, date: 'Mar-27', time: '03:00 PM', title: 'Cybersecurity and Policy Class Session', parentId: 'item-02' },
    { id: 8, date: 'Mar-30', time: '04:00 PM', title: 'How to Work a Career Fair Workshop', parentId: 'item-02' },
    { id: 9, date: 'Mar-22', time: '09:00 AM', title: 'D’Amore-McKim Career Webinar: Conducting a Remote Job Search', parentId: 'item-03' },
    { id: 10, date: 'Mar-30', time: '09:00 AM', title: 'Career by Design Webinar: Know Your Worth: Negotiating Your Next Job Offer', parentId: 'item-03' },
    { id: 11, date: 'Mar-13', time: '07:30 PM', title: 'Lifestyle Management -- Ultimate guide to striking a work-life balance', parentId: 'item-04' },
    { id: 12, date: 'Mar-15', time: '09:00 AM', title: 'Networking and Informational Interviewing', parentId: 'item-04' },
    { id: 13, date: 'Mar-11', time: '03:00 PM', title: 'Better Money Habits Webinar: Personal Finance 101', parentId: 'item-04' },
    { id: 14, date: 'Mar-26', time: '06:00 PM', title: 'ASB Post-Break Celebration', parentId: 'item-05' },
    { id: 15, date: 'Apr-02', time: '08:00 AM', title: 'Walk MS Boston', parentId: 'item-05' }
];


export function getEvents(parentId) {
    const events = [];
    for (let i = 0; i < eventItems.length; i++) {
        if (eventItems[i].parentId === parentId) {
            events.push(eventItems[i]);
        }       
    }
     return events;
}