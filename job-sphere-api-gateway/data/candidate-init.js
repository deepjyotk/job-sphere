// Create database
db = db.getSiblingDB('candidate');

// Create user
db.createUser({
  user: 'candidate_user',
  pwd: 'candidate_password',
  roles: [
    {
      role: 'readWrite',
      db: 'candidate'
    }
  ]
});

// Create collection
db.createCollection('candidate');

// Insert documents
db.candidate.insertMany([
  {
    _id: '1',
    name: 'sam',
    skills: ['java', 'sql']
  },
    {
      _id: '2',
      name: 'jake',
      skills: ['docker']
    },
    {
            _id: '3',
            name: 'mike',
            skills: ['jira']
     }
]);
